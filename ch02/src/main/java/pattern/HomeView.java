package pattern;

public class HomeView extends Command {
    @Override
    public void excute() {
        forward("/home.jsp");
    }
}
