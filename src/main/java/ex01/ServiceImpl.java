package ex01;

public class ServiceImpl implements Service {

	//핵심로직을 수행하는 메서드
	@Override
	public void sayHello(String... names) {
		if(names!=null) {
			for(String name:names) {
				System.out.println("Hello~~~"+name);
			}
		}
	}

}
