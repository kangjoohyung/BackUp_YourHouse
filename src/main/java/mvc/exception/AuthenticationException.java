package mvc.exception;
/**
 * �α����Ҷ� ���, �н����尡 Ʋ������ ������ �����Ҷ� �߻��ϴ� ����
 * */
public class AuthenticationException extends Exception {
   public AuthenticationException() {}
   public AuthenticationException(String message) {
	   super(message);
   }
}
