package com.baibao.web.p2p.controller.wap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WapController
{
	@RequestMapping("/waptip")
	public String waptip()
	{
		return "/wap/tip";
	}
}
