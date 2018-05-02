package com.antonina.health.controller;

import com.antonina.health.repository.ResultRepository;
import com.antonina.health.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private final ResultRepository repository;
    private final UserService userService;

    public HistoryController(ResultRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @GetMapping
    public String history(@RequestParam(required = false, defaultValue = "0") int page,
                          @RequestParam(required = false, defaultValue = "dateTime") String sort,
                          @RequestParam(required = false, defaultValue = "desc") String dir,
                          Model model) {

        Sort.Direction direction = Sort.Direction.fromString(dir);
        Sort sortBy = Sort.by(direction, sort);
        Pageable pageRequest = PageRequest.of(page, 8, sortBy);

        Long userId = userService.getLoggedUser().getId();
        model.addAttribute("results", repository.findByUserId(userId, pageRequest));
        model.addAttribute("sort", sort);
        model.addAttribute("dir", dir);

        return "history";
    }
}