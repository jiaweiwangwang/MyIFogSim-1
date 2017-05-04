package org.fog.localization;

import java.util.Arrays;

import org.fog.entities.*;
import org.fog.vmmobile.constants.*;


public class Coordinate { //extends Map {

	private int coordX;
	private int coordY;
	//	private int positions[][];

	//	public Coordinate(int sizeX, int sizeY) {
	//		// TODO Auto-generated constructor stub
	//		this.positions = new int[sizeX][sizeY];
	//		for(int i=0;i<sizeX;i++)
	//			for(int j=0;j<sizeY;j++)
	//				this.positions[i][j] = -1;
	//	}
	public Coordinate(){
		//		positions=null;
	}

	public  boolean isWithinLimitPosition(Coordinate c){
		if (c.getCoordX()>=MaxAndMin.MAX_X||
				c.getCoordX()<0||
				c.getCoordY()>=MaxAndMin.MAX_Y||
				c.getCoordY()<0)
			return false;
		else
			return true;
	}
	public  void desableSmartThing(MobileDevice smartThing){
		//	System.out.println("Removing SmartThing: "+smartThing.getId());
		smartThing.setCoord((int) -1, (int)-1);
	}
	public  void newCoordinate(MobileDevice smartThing, int add, Coordinate coordDevices){//(pointUSER user,float add)

		if(smartThing.getSpeed()!=0){
			int increaseX= (smartThing.getCoord().getCoordX()+(smartThing.getSpeed()*add));
			int increaseY= (smartThing.getCoord().getCoordY()+(smartThing.getSpeed()*add));
			int decreaseX= (smartThing.getCoord().getCoordX()-(smartThing.getSpeed()*add));
			int decreaseY= (smartThing.getCoord().getCoordY()-(smartThing.getSpeed()*add));
			int direction= smartThing.getDirection();
			int oldCoordX = smartThing.getCoord().getCoordX();
			int oldCoordY = smartThing.getCoord().getCoordY();

			//			while(true){
			//	System.out.println("id: "+smartThing.getId()+"Direction: "+direction);
			if(decreaseX<0||decreaseY<0||increaseX>=MaxAndMin.MAX_X||increaseY>=MaxAndMin.MAX_Y){//It checks the CoordDevices limits.
				desableSmartThing(smartThing);
				//					coordDevices.setPositions(-1, oldCoordX, oldCoordY);
//				break;
				return;
			}

			if(direction==Directions.EAST){
				/*same Y, increase X*/
				//					if(coordDevices.getPositions(increaseX, oldCoordY)==-1){	
				smartThing.getCoord().setCoordX(increaseX);
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
//				break;
				//					}
				//					else increaseX++;//next position in the same direction
			}
			else if(direction==Directions.WEST){
				/*same Y, decrease X*/
				//					if(coordDevices.getPositions(decreaseX, oldCoordY)==-1){	
				smartThing.getCoord().setCoordX(decreaseX);//next position in the same direction
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
				//						break;
				//					}
				//					else decreaseX--;//next position in the same direction
			}
			else if(direction==Directions.SOUTH){//Directions.NORTH){
				/*same X, increase Y*/
				//					if(coordDevices.getPositions(oldCoordX, increaseY)==-1){	
				smartThing.getCoord().setCoordY(increaseY);//next position in the same direction
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
				//						break;
				//					}
				//					else increaseY++;//next position in the same direction
			}
			else if(direction==Directions.NORTH){//Directions.SOUTH){
				/*same X, decrease Y*/
				//					if(coordDevices.getPositions(oldCoordX, decreaseY)==-1){	
				smartThing.getCoord().setCoordY(decreaseY);
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
				//						break;
				//					}
				//					else decreaseY--;//next position in the same direction
			}
			else if(direction==Directions.SOUTHEAST){//Directions.NORTHEAST){
				/*increase X and Y*/
				//					if(coordDevices.getPositions(increaseX, increaseY)==-1){	
				smartThing.getCoord().setCoordX(increaseX);
				smartThing.getCoord().setCoordY(increaseY);
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
				//						break;
				//					}
				//					else {
				//						increaseX++;//next position in the same direction
				//						increaseY++;//next position in the same direction
				//					}

			}
			else if(direction==Directions.NORTHWEST){//Directions.SOUTHWEST){
				/*decrease X and Y*/
				//					if(coordDevices.getPositions(decreaseX, decreaseY)==-1){	
				smartThing.getCoord().setCoordX(decreaseX);
				smartThing.getCoord().setCoordY(decreaseY);
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
				//						break;
				//					}
				//					else {
				//						decreaseX--;//next position in the same direction
				//						decreaseY--;//next position in the same direction
				//					}

			}
			else if(direction==Directions.SOUTHWEST){//Directions.NORTHWEST){
				/*decrease X increase Y*/
				//					if(coordDevices.getPositions(decreaseX, increaseY)==-1){	
				smartThing.getCoord().setCoordX(decreaseX);
				smartThing.getCoord().setCoordY(increaseY);
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
				//						break;
				//					}
				//					else {
				//						decreaseX--;//next position in the same direction
				//						increaseY++;//next position in the same direction
				//					}				

			}
			else if(direction==Directions.NORTHEAST){//Directions.SOUTHEAST){
				/*increase X decrease Y*/
				//					if(coordDevices.getPositions(increaseX, decreaseY)==-1){	
				smartThing.getCoord().setCoordX(increaseX);
				smartThing.getCoord().setCoordY(decreaseY);
				//						coordDevices.setPositions(smartThing.getId(), smartThing.getCoord().getCoordX(), smartThing.getCoord().getCoordY());//new position with new value
				//						coordDevices.setPositions(-1, oldCoordX, oldCoordY);// Disable old position
				//						break;
				//					}
				//					else {
				//						increaseX++;//next position in the same direction
				//						decreaseY--;//next position in the same direction
				//					}
				//				}
			}
		}
	}





	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	//	public int getPositions(int x, int y) {
	//		return positions[x][y];
	//	}
	//
	//	public void setPositions(int id, int x, int y) {		
	//		this.positions[x][y] = id;
	//
	//	}

	//	@Override
	//	public String toString() {
	//		return "Coordinate [coordX=" + coordX + ", coordY=" + coordY
	//				+ ", positions=" + Arrays.toString(positions) + "]";
	//	}

}