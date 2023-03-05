import java.util.*;

public class GlobalMembers
{
	public static void main(int argc, String[] args)
	{
		ArrayList<String> args = new ArrayList<String>(args + 1, args + argc);
		SLLJoinLists.main(args);
	}


}