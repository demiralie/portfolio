package com.example.controller;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.WebBoard;
import com.example.persistence.WebBoardRepository;
import com.example.vo.PageMaker;
import com.example.vo.PageVO;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/main")
@Log
public class MainController {

	@Inject
	WebBoardRepository repo;

	
	@GetMapping("/main")
	public String list(@ModelAttribute("pageVO") PageVO vo, Model model) {

		Pageable pageable = vo.makePageable(0, "bno");

		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());

		// Page<WebBoard> result = repo.findAll(repo.makePredicate(vo.getType(),
		// vo.getKeyword()), page);
		Page<WebBoard> result = repo.findAll(predicate, pageable);

		log.info("" + pageable);
		log.info("" + result);

		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());

		model.addAttribute("pageMaker", new PageMaker<WebBoard>(result));

		return "jsp/main/main";

	}

}
