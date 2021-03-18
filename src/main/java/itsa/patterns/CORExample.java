package itsa.patterns;

interface Approver {
    ApproverHandler getNextApprover();
}

class ApproverHandler implements Approver {
    private int limit = 0;
    private String id = "";
    private ApproverHandler nextApproverHandler = null;

    public ApproverHandler(String id, int limit) {
        this.limit = limit;
        this.id = id;
    }

    public int getLimit() {
        return limit;
    }

    public String execute(int value) {
        if (value <= limit) {
            // System.out.println("" + this.id + " is handling: " + Integer.toString(value));
            return this.id;
        }
        // System.out.println(this.id + "passed to next approver: ");
        return this.id + nextApproverHandler.execute(value);
    }

    //skeleton code for you add the handlers into a chain
    public void add(ApproverHandler handler) {
        if (nextApproverHandler == null) {
            this.nextApproverHandler = handler;
        } else {
            this.nextApproverHandler.add(handler);
        }
    }

    public ApproverHandler getNextApprover() {
        return nextApproverHandler;
    }
}

public class CORExample {
    public static void main(String[] args) {
        ApproverHandler approver1 = new ApproverHandler("1", 500);
        ApproverHandler approver2 = new ApproverHandler("2", 1000);
        ApproverHandler approver3 = new ApproverHandler("3", 1500);
        ApproverHandler approver4 = new ApproverHandler("4", 1000000);

        // approver1: 1 -> null
        approver1.add(approver2); // 1 -> 2 -> null
        approver1.add(approver3); // 1 -> 2 -> 3 -> null
        approver1.add(approver4); // 1 -> 2 -> 3 -> 4 -> null

        int[] requests = {500, 1000, 1500, 5000};
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < requests.length; i++) {

            ans.append(approver1.execute(requests[i]));

            // fence post the output: ans
            if (i < requests.length - 1) {
                ans.append('-');
            }

            // if (requests[i] <= approver1.getLimit()) {
            // 	System.out.println("handled by approver1");
            // 	ans += approver1.execute(requests[i]);
            // } else if (requests[i] <= approver2.getLimit()) {
            // 	System.out.println("handled by approver2");
            // 	ans += approver2.execute(requests[i]);
            // } else if (requests[i] <= approver3.getLimit()) {
            // 	System.out.println("handled by approver3");
            // 	ans += approver3.execute(requests[i]);
            // } else if (requests[i] <= approver4.getLimit()) {
            // 	System.out.println("handled by approver4");
            // 	ans += approver4.execute(requests[i]);
            // }
        }
        System.out.println("The requests are handled in the sequence " + ans);

        // In COR, the sequence should be 1-12-123-1234
        assert ans.toString().equals("1-12-123-1234") : "Sequence does not matched";

    }
}