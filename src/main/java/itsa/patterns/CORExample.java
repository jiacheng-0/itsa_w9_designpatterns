package itsa.patterns;

import java.util.*;

class ApproverHandler {
	private int limit = 0;
	private String id = "";
	
	public ApproverHandler(String id, int limit) {
		this.limit = limit;
		this.id = id;
	}

	public int getLimit() {
		return limit;
	}
    public String execute(int value) {
        return id;
    }
	
	//skeleton code for you add the handlers into a chain
	public void add(ApproverHandler handler) {
	}
}

public class CORExample {
    public static void main(String[] args) {
        ApproverHandler approver1 = new ApproverHandler("1", 500);
		ApproverHandler approver2 = new ApproverHandler("2", 1000);
        ApproverHandler approver3 = new ApproverHandler("3", 1500);
		ApproverHandler approver4 = new ApproverHandler("4", 1000000);
		
		int[] requests = {500, 1000, 1500, 5000};
		String ans = "";
		for (int i=0; i < requests.length; i++) {
			if (requests[i] <= approver1.getLimit()) {
				System.out.println("handled by approver1");
				ans += approver1.execute(requests[i]);
			} else if (requests[i] <= approver2.getLimit()) {
				System.out.println("handled by approver2");
				ans += approver2.execute(requests[i]);
			} else if (requests[i] <= approver3.getLimit()) {
				System.out.println("handled by approver3");
				ans += approver3.execute(requests[i]);
			} else if (requests[i] <= approver4.getLimit()) {
				System.out.println("handled by approver4");
				ans += approver4.execute(requests[i]);
			}
		}
		System.out.println("The requests are handled in the sequence " + ans);
        
		// In COR, the sequence should be 1-12-123-1234
		assert ans.equals("1-12-123-1234") : "Sequence does not matched";

    }
}