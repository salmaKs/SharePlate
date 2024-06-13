package tn.esprit.shareplate.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.shareplate.entities.Receipt;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.services.IReceiptService;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ReceiptController {
    @Autowired
    private IReceiptService iReceiptService;

    @PostMapping("/addReceipt/{id}")
    public void addReceipt (@RequestBody Receipt receipt, @PathVariable Long id){
       iReceiptService.addReceipt(receipt,id);
    }
    @PutMapping("/modifyReceipt/{id}")
    public void modifyReceipt (@RequestBody Receipt receipt , @PathVariable Long id){
        iReceiptService.updateReceipt(receipt, id);
    }
    @DeleteMapping("/deleteReceipt/{id}")
    public void deleteReceipt (@PathVariable Long id){
        iReceiptService.deleteReceipt(id);
    }
    @GetMapping("/getReceiptById/{id}")
    public Receipt getReceiptById(@PathVariable Long id){
        return iReceiptService.findReceiptById(id);
    }
    @GetMapping("/getallReceipt")
    public List<Receipt> getAllReceipt(){
        return iReceiptService.findAllReceipt();
    }
    @GetMapping("/getReceiptByDate")
    public List<Receipt> getReiptByDate(@RequestParam Date dateR) {
        return iReceiptService.getReceiptByDate(dateR);
    }
}
