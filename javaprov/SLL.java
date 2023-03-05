import java.util.*;
import java.io.*;

//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template<typename E>
public class SLL<E> implements Closeable
{
//C++ TO JAVA CONVERTER TODO TASK: There is no equivalent in Java to 'static_assert':
//	static_assert(std::is_base_of<Comparable <E>, E>::value, "E must inherit from Comparable <E>");

	private SLLNode<E> first;

	public void close()
	{
		if (first != null)
		{
			first.close();
		}
	}

	public SLL()
	{
		this.first = null;
	}
	public void insertFirst(E o)
	{
		SLLNode<E> insert = new SLLNode<E>(o, first);
		first = insert;

//JAVA TO C++ CONVERTER TODO TASK: A 'delete insert' statement was not added since insert was assigned to a field. Handle memory management manually.
	}
	public void insertLast(E o)
	{
		if (first != null)
		{
			SLLNode<E> current = first;
			while (current.successor != null)
			{
				current = current.successor;
			}
			SLLNode<E> insert = new SLLNode<E>(o, null);
			current.successor = insert;

//JAVA TO C++ CONVERTER TODO TASK: A 'delete insert' statement was not added since insert was assigned to a field. Handle memory management manually.
		}
		else
		{
			insertFirst(o);
		}
	}
	public SLLNode<E> getFirst()
	{
		return first;
	}
	public Iterator<E> interator()
	{
		return new LRIterator<E>(this);
	}
//C++ TO JAVA CONVERTER WARNING: The original C++ template specifier was replaced with a Java generic specifier, which may not produce the same behavior:
//ORIGINAL LINE: template<typename E>
	private static class LRIterator<E> implements Closeable, Iterator<E> {
		private SLL<E> outerInstance;

		private SLLNode<E> place;
		private SLLNode<E> current;

		public void close()
		{
			if (place != null)
			{
				place.close();
			}
			if (current != null)
			{
				current.close();
			}
			if (outerInstance != null)
			{
				outerInstance.close();
			}
		}

		private LRIterator(SLL<E> outerInstance)
		{
			this.outerInstance = outerInstance;
			place = (SLLNode<E>)outerInstance.first;
			current = null;
		}
		public boolean hasNext()
		{
			return place != null;
		}
		public E next()
		{
			if (place == null)
			{
				throw new NoSuchElementException();
			}
			E nextElement = place.element;
			current = place;
			place = place.successor;
			return nextElement;
		}
	}
	public SLL<E> joinLists(SLL<E> add)
	{
		SLL<E> merged = new SLL<E>();
		SLLNode<E> listOneNode = first;
		SLLNode<E> listTwoNode = add.getFirst();
		while (listOneNode != null && listTwoNode != null)
		{
			if (listOneNode.element.compareTo(listTwoNode.element) < 0)
			{
				merged.insertLast(listOneNode.element);
				listOneNode = listOneNode.successor;
			}
			else
			{
				merged.insertLast(listTwoNode.element);
				listTwoNode = listTwoNode.successor;
			}
		}
		if (listOneNode != null)
		{
			while (listOneNode != null)
			{
				merged.insertLast(listOneNode.element);
				listOneNode = listOneNode.successor;
			}
		}
		if (listTwoNode != null)
		{
			while (listTwoNode != null)
			{
				merged.insertLast(listTwoNode.element);
				listTwoNode = listTwoNode.successor;
			}
		}
		SLLNode<E> tmp = merged.getFirst();
		while (tmp.successor != null)
		{
			if (tmp.element.compareTo(tmp.successor.element) == 0 && tmp.successor.successor != null)
			{
				tmp.successor = tmp.successor.successor;
			}
			else if (tmp.element.compareTo(tmp.successor.element) == 0 && tmp.successor.successor == null)
			{
				tmp.successor = null;
			}
			else
			{
				tmp = tmp.successor;
			}
		}

//JAVA TO C++ CONVERTER TODO TASK: A 'delete merged' statement was not added since merged was used in a 'return' or 'throw' statement.
		return merged;
	}
}