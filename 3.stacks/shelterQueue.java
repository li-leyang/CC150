import java.util.LinkedList;
import java.util.Stack;

/*3.7 implement the dog and cat and animal shelter linked list as a queue.
 * implement enqueue, dequeue of any type, dequeue of a specific type
 * enqueue: O(1)
 * dequeue: all O(1)
 * 
 * */
class Animal{
	String name;
	public static int count=0;
	public final int id;
	public Animal(String name){
		this.name=name;
		id=count++;
	}
	public int getid(){
		return id;
	}

}
class Cat extends Animal{

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
class Dog extends Animal{

	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
}
class Shelter{
	LinkedList<Cat> cat;
	LinkedList<Dog> dog;
	public Shelter(){
		cat=new LinkedList<Cat>();
		dog=new LinkedList<Dog>();
	}
	public void enqueue(Animal animal){
		if(animal instanceof Cat)
			cat.add((Cat)animal);
		else
			dog.add((Dog)animal);
	}
	public Cat dequeueCat(){
		return cat.remove();
	}
	public Dog dequeueDog(){
		return dog.remove();
	}
	public Animal dequeueany(){
		if(cat.isEmpty())
			return dog.remove();
		if(dog.isEmpty())
			return cat.remove();
		if(cat.peek().id<dog.peek().id)
			return cat.remove();
		else
			return dog.remove();
	}
	
}
public class shelterQueue{
	public static void main(String[] args){
		Shelter shelter=new Shelter();
		Cat a=new Cat("ss");
		Dog cc=new Dog("sd");
		Cat b=new  Cat("dd");
		Dog bb=new Dog("sss");
		Dog j=new Dog("qq");
		shelter.enqueue(a);
		shelter.enqueue(cc);
		shelter.enqueue(b);
		shelter.enqueue(bb);
		shelter.enqueue(j);
		System.out.println(shelter.dequeueDog().name);
//		System.out.println()
	}
}