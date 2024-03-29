package ex02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

//Advice: 공통 관심사항
public class CommonAspect {
	//JoinPoint: Target객체가 가진 메서드
	public void trace1(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("==before=======["+sign.toShortString()+"]");
	}
	public void trace2(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("==after=======["+sign.toShortString()+"]");
	}
	
	public void trace3(JoinPoint jp, Integer result) {
		Signature sign=jp.getSignature();
		System.out.println("==after returning =======["+sign.toShortString()+"] 반환값: "+result);
	}
	public void trace4(JoinPoint jp, Exception ex) {
		Signature sign=jp.getSignature();
		System.out.println("==after throwing =======["+sign.toShortString()+"]");
		if(ex!=null) {
			System.out.println("발생된 예외: "+ex);
		}
	}
	
	public Integer trace5(ProceedingJoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("==around(before)==========["+sign.toShortString()+"]=start=");
		try {
			Integer n=(Integer)jp.proceed();
			return n;
		}catch(Throwable e) {
			e.printStackTrace();
			return null;
		}finally {
			System.out.println("==around(after)==========["+sign.toShortString()+"]=end=");	
		}
	}
}
