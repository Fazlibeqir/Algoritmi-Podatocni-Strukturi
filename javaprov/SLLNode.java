import java.util.*;
import java.io.*;

//====================================================================================================
//The Free Edition of Java to C++ Converter limits conversion output to 100 lines per file.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-java-to-cplus.html
//====================================================================================================



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