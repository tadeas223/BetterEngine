import org.example.base.GameComponent;
import org.example.components.MovementController;

public class PlayerComponent extends GameComponent {
    @Override
    protected void requirements() {
        require(MovementController.class);
    }

    @Override
    public void start() {
        System.out.println("Component start");
    }

    @Override
    public void update(float deltaTime) {
        System.out.println("speed = " + getClass().getComponentType());
    }
}
