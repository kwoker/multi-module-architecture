package com.keveon.architecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Keveon on 2017/2/28.
 * Swagger2 page jump controller
 */
@Controller
public class SwaggerJumpController {
	@RequestMapping(value = "/api")
	public String index() {
		return "redirect:swagger-ui.html";
	}
}
