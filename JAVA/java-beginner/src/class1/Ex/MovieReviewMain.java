package class1.Ex;

public class MovieReviewMain {

    public static void main(String[] args) {
        MovieReview mv1 = new MovieReview();
        mv1.title = "Gogila";
        mv1.review = "Good";

        MovieReview mv2 = new MovieReview();
        mv2.title = "TomBoy";
        mv2.review = "Bad";

        MovieReview mv3 = new MovieReview();
        mv3.title = "HellBoy";
        mv3.review = "Very Good";

        MovieReview mv4 = new MovieReview();
        mv4.title = "Rich";
        mv4.review = "God";

        MovieReview[] mvs = {mv1,mv2,mv3,mv4};

        for (MovieReview s : mvs) {
            System.out.println("title : " + s.title + ", review : " + s.review);
        }
    }
}
