package com.peng.spring;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	/*在ModelAndView对象中传递了一个名为“command”的空对象，因为如果在JSP中使用<form：form>标签，
	 * spring框架需要一个名为“command”的对象文件。
	所以当调用logo()方法时，它返回logo.jsp视图。*/
	/*@RequestMapping(value = "/logo" , method = RequestMethod.GET)
	public ModelAndView logo() {
		return new ModelAndView("logo" , "command" , new Logobean() );
	}
	
	@RequestMapping(value = "/addlogo" , method = RequestMethod.POST)
	public String addlogo(@ModelAttribute("SpringWeb")Logobean logobean ,
			ModelMap model) {
		model.addAttribute("imagepath", logobean.getImagepath());
		model.addAttribute("title", logobean.getTitle());
		model.addAttribute("cTime", logobean.getcTime());
		model.addAttribute("id", logobean.getId());
		
		//从服务方法返回“result”视图，这将最终渲染result.jsp视图
		return "result";
	}*/
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value = "/logo", method = RequestMethod.GET)
	   public ModelAndView fileUploadPage() {
	      Logobean file = new Logobean();
	      ModelAndView modelAndView = new ModelAndView("logo", "command", file);
	      return modelAndView;
	   }

	   @RequestMapping(value="/logo", method = RequestMethod.POST)
	   public String fileUpload(@Validated Logobean file, BindingResult result, ModelMap model) throws IOException {
	      if (result.hasErrors()) {
	         System.out.println("validation errors");
	         return "logo";
	      } else {            
	         System.out.println("Fetching file");
	         MultipartFile multipartFile = file.getFile();
	         String uploadPath = context.getRealPath("") + File.separator + "temp" + File.separator;
	         //Now do something with file...
	         String filepath = uploadPath+file.getFile().getOriginalFilename();
	         FileCopyUtils.copy(file.getFile().getBytes(), new File(filepath));
	         String fileName = multipartFile.getOriginalFilename();
	         model.addAttribute("fileName", fileName);
	         model.addAttribute("imagepath", filepath);
	 		 model.addAttribute("title", file.getTitle());
	 		 model.addAttribute("cTime", file.getcTime());
	 		 model.addAttribute("id", file.getId());
	         return "success";
	      }
	   }
}
