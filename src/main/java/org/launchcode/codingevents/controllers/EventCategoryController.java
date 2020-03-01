package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllEventCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("eventCategories", eventCategoryRepository.findAll());
        return "eventCategories/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new EventCategory());
//        model.addAttribute("categories", eventCategoryRepository.findAll());
//        model.addAttribute("types", eventCategoryRepository.findAll());
//        model.addAttribute("categories", EventType.values());
        return "eventCategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newEventCategory,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            return "eventCategories/create";
        }

        eventCategoryRepository.save(newEventCategory);
        return "redirect:";
//        or return "eventCategories/create", "redirect:"
    }
}
