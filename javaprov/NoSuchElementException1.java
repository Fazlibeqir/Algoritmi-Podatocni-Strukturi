public class NoSuchElementException extends RuntimeException
{
	private String msg;

	public NoSuchElementException()
	{
		this("");
	}
//C++ TO JAVA CONVERTER NOTE: Java does not allow default values for parameters. Overloaded methods are inserted above:
//ORIGINAL LINE: NoSuchElementException(const String& message = "") : msg(message)
	public NoSuchElementException(final String message)
	{
		this.msg = message;
	}

//C++ TO JAVA CONVERTER TODO TASK: Java has no equivalent to 'noexcept':
//ORIGINAL LINE: const char * what() const noexcept
	public final String what()
	{
		return msg;
	}
}