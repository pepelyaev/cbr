package com.example.demo.web;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.*;
import com.example.demo.service.AccountingService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MvcController {

    @Autowired
    ProjectService projectService;

    @Autowired
    WorkerService workerService;

    @Autowired
    AccountingService accountingService;

    //------------------------------------------------------------------------------------------------------
    @RequestMapping(path = {"/accountingList", "/accountingList/{id}"})
    public String accountingList(Model model, @PathVariable("id") Optional<Long> id) {
        List<AccountingEntity> list = accountingService.getAccountingFilter((id.isPresent() ? id.get() : null));

        System.out.println("filterWorkerId = "+ (id.isPresent() ? id.get() : 0L));

        model.addAttribute("accounting", list);
        model.addAttribute("filter", (id.isPresent() ? id.get() : 0L));

        List<ProjectEntity> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);

        List<WorkerEntity> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);

        return "accountingList";
    }

    @RequestMapping(path = {"/accountingEdit", "/accountingEdit/{id}"})
    public String accountingEditById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        AccountingEntity entity;
        if (id.isPresent()) {
            entity = accountingService.getAccountingById(id.get());
        } else {
            entity = new AccountingEntity();
            entity.setProjectId(0L);
            entity.setWorkerId(0L);
            entity.setDate(new Date());
            entity.setHms(30);
        }
        model.addAttribute("accounting", entity);

        List<ProjectEntity> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);

        List<WorkerEntity> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);

        return "accountingEdit";
    }

    @RequestMapping(path = "/accountingDelete/{id}")
    public String accountingDeleteById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException {
        accountingService.deleteAccountingById(id);
        return "redirect:/accountingList";
    }

    @RequestMapping(path = "/accountingCreate", method = RequestMethod.POST)
    public String accountingCreateOrUpdate(AccountingEntity accounting) {
        if (accounting.getProjectId() != 0 && accounting.getWorkerId() != 0 && !accounting.getTask().isEmpty()
                && accounting.getDate() != null && accounting.getHms() > 0) {
            accountingService.accountingCreateOrUpdate(accounting);
        }
        return "redirect:/accountingList";
    }
}
