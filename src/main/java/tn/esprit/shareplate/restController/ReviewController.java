package tn.esprit.shareplate.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.shareplate.entities.Review;
import tn.esprit.shareplate.entities.User;
import tn.esprit.shareplate.services.IReviewService;
import tn.esprit.shareplate.services.ReviewService;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private IReviewService iReviewService;

    @PostMapping("/addReview")
    public void addReview (@RequestBody Review review){
        iReviewService.addReview(review);
    }
    @PutMapping("/modifyReview/{id}")
    public void modifyUReview (@RequestBody Review review , @PathVariable Long id){
       iReviewService.updateReview(review, id);
    }
    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview (@PathVariable int id){
        iReviewService.deleteReview(id);
    }
    @GetMapping("/getReviewById/{id}")
    public Review getReviewById(@PathVariable Long id){
        return iReviewService.findReviewById(id);
    }
    @GetMapping("/getallReview")
    public List<Review> getAllReview(){
        return iReviewService.findAllReview();
    }
}
