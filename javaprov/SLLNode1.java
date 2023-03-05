import java.util.*;
import java.io.*;

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template<typename E>
public class SLLNode<E> implements Closeable
{
	protected E element = new E();
	protected SLLNode<E> successor;
	public void close()
	{
		if (successor != null)
		{
			successor.close();
		}
	}

	public SLLNode(E element, SLLNode<E> successor)
	{
		this.element = element;
		this.successor = successor;
	}
}