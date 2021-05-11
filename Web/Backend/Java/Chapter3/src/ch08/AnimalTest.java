package ch08;

import java.util.ArrayList;

class Animal{
	public void move() {
		System.out.println("������ �����Դϴ�");
	}
	public void eat() {
		
	}
}

class Human extends Animal{

	@Override
	public void move() {
		System.out.println("����� �� �߷� �Ƚ��ϴ�");
	}
	public void read() {
		System.out.println("����� å�� �н��ϴ�");
	}
	
}

class Tiger extends Animal{

	@Override
	public void move() {
		System.out.println("ȣ���̰� �� �߷� �ݴϴ�");
	}
	public void hunt() {
		System.out.println("ȣ���̰� ����� �մϴ�");
	}
	
}

class Eagle extends Animal{

	@Override
	public void move() {
		System.out.println("�������� �ϴ��� ���ϴ�");
	}
	public void fly() {
		System.out.println("�������� �ϴ��� ������ ���ϴ�");
	}
	
}

public class AnimalTest {

	public static void main(String[] args) {
		
		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();
		
		AnimalTest test = new AnimalTest();
//		test.moveAnimal(hAnimal);
//		test.moveAnimal(tAnimal);
//		test.moveAnimal(eAnimal);
		
		ArrayList<Animal> animalList = new ArrayList<>();
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);
		
		for(Animal animal : animalList) {
			animal.move();
		}
		
		test.testDownCasting(animalList);
	}
	
	public void testDownCasting(ArrayList<Animal> list) {
		for(int i = 0; i < list.size(); i++) {
			Animal animal = list.get(i);
			
			if(animal instanceof Human) {
				Human human = (Human) animal;
				human.read();
			}
			else if(animal instanceof Tiger) {
				Tiger tiger = (Tiger) animal;
				tiger.hunt();
			}
			else if(animal instanceof Eagle) {
				Eagle eagle = (Eagle) animal;
				eagle.fly();
			}
			else {
				System.out.println("No type");
			}
		}
	}
	
	public void moveAnimal(Animal animal) {
		animal.move();
	}
}
