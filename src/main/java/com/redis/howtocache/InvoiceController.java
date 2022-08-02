package com.redis.howtocache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/saveInv")
    public Invoice saveInvoice(@RequestBody Invoice inv) {
        return invoiceService.saveInvoice(inv);
    }

    @Cacheable(value = "InvoiceAll")
    @GetMapping("/allInv")
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/getOne/{id}")
    public Invoice getOneInvoice(@PathVariable Integer id) {
        return invoiceService.getOneInvoice(id);
    }

    @PutMapping("/modify/{id}")
    public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Integer id) {
        return invoiceService.updateInvoice(inv, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Integer id) {
        try{
            invoiceService.deleteInvoice(id);
        }
        catch (InvoiceNotFoundException e)
        {

        }
        return "Employee with id: "+id+ " Deleted !";
    }
}