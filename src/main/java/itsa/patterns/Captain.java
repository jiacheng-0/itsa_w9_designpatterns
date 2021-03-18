
package itsa.patterns;

public class Captain
{
	// Use this static method as skeleton for modification
 	public static Captain getCaptain() {
		return new Captain();
	}

    public static void main(String[] args) {
        
        System.out.println("Trying to make a captain for your team:");
        Captain captain1 = new Captain();
        System.out.println("Trying to make another captain for your team:");
        Captain captain2 = new Captain();
        if (captain1 == captain2)
        {
            System.out.println("captain1 and captain2 are same instance.");
        } else {
			System.out.println("captain1 and captain2 are not the same instance.");
		}
    }
}
