import java.awt.Color;
import java.awt.Graphics;


public class WallJump extends Circle{

	int d=0;
	Color color;
	
	public WallJump(){
		size = 100;
		gravity = 0.3f;
	}

	
	public void AplicarGravedad(){
		if(d==0){
			velocityX += gravity;
			color=Color.green;
		}else{
			velocityX -= gravity;
			color=Color.yellow;
		}
	}

	public void DetectarSuelo(){
		if(positionX +size > 800){
			d=1;
		}else if(positionX<0){
			d=0;
		}
	}
	
	public void Draw (Graphics g){
		g.setColor(color);
		g.fillOval(positionX,positionY,size,size);
	}
}