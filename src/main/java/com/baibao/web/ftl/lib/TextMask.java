package com.baibao.web.ftl.lib;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class TextMask
	implements TemplateMethodModelEx
{
	public static String mask(
		String text, int length, String mode)
	{
		char[] orgiseq = text.toCharArray();
		char[] charseq = new char[text.length()];

		if (length > orgiseq.length)
			length = orgiseq.length;

		Arrays.fill(charseq, 'x');

		if (mode.indexOf("p") != -1)
			System.arraycopy(orgiseq, 0, charseq, 0, length);
		
		if (mode.indexOf("s") != -1)
			System.arraycopy(orgiseq,
				orgiseq.length - length,
				charseq, charseq.length - length, length);

		return new String(charseq);
	}

	public static void install(Model model)
	{
		model.addAttribute("mask", new TextMask());
	}

	@Override
	public Object exec(List arguments)
		throws TemplateModelException
	{
		if (arguments.size() < 1)
			throw new TemplateModelException("Wrong arguments");

		int length = 1;
		String mode = "s";

		String text = String.valueOf(arguments.get(0));

		if (arguments.size() > 1)
		{
			length =
				Integer.parseInt(
					String.valueOf(arguments.get(1)));
		}

		if (arguments.size() > 2)
		{
			mode = String.valueOf(arguments.get(2));
		}

		return new SimpleScalar(mask(text, length, mode));
	}
}
