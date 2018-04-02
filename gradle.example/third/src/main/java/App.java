public class App {
	
    public String getGreeting() {
        return "Greetings";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
