package org.vasyapupkin.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vasyapupkin.model.Parts;
import org.vasyapupkin.service.PartsService;

import javax.ws.rs.Path;
import java.util.List;

@Controller
public class PartsController {

    private PartsService partsService;

    @Autowired
    public void setPartsService(PartsService partsService) {
        this.partsService = partsService;
    }

    @RequestMapping(value = "/parts/{id}", method = RequestMethod.GET)
    public String listParts(Model model, @PathVariable("id") int id, @RequestParam(value = "relevance",required = false) String relevance) {

        List<Parts> parts = null;
        if (relevance == null || relevance.equals("all")) {
            parts = partsService.findAllByPages(id, 10);
            model.addAttribute("fullRelevance", "true");
            model.addAttribute("count", partsService.count());
        } else if (relevance.equals("true")) {
            parts = partsService.findAllByRelevanceAndPages(id, 10, true);
            model.addAttribute("trueRelevance", "true");
            model.addAttribute("count", partsService.count());
        } else if (relevance.equals("false")) {
            parts = partsService.findAllByRelevanceAndPages(id, 10, false);
            model.addAttribute("falseRelevance", "true");
            model.addAttribute("count", partsService.count());
        }

        model.addAttribute("partsList", parts);
        model.addAttribute("part", new Parts());

        return "/parts";
    }

    @RequestMapping(value = "parts/searchUser", method = RequestMethod.GET)
    public String search(@ModelAttribute("searchName") String string, Model model) {
        Parts parts = partsService.findByName(string);
        if (parts != null)
            model.addAttribute("partFound", partsService.findByName(string));
        else
            model.addAttribute("notFound", "true");
        return "/parts";
    }


    @RequestMapping(value = "parts/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        partsService.deleteById(id);
        return "redirect:/parts/1";
    }

    @RequestMapping(value = "/add-edit")
    public String addEdit(Model model) {
        model.addAttribute("part", new Parts());
        return "/add-edit";
    }

    @RequestMapping(value = "parts/add-edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("part", partsService.findById(id));
        return "/add-edit";
    }




    @RequestMapping(value = "/add-edit/addAction", method = RequestMethod.POST)
    public String addPart(@ModelAttribute("part") Parts part) {
        System.out.println("addAction-Controller");
        System.out.println(part);
        if (part.getId() == 0)
            partsService.add(part);
        else
            partsService.update(part);

        return "redirect:/parts/1";
    }



}
