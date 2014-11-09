public interface ListTester {
	
	/**
	 * @return the number of milliseconds it takes to add a million elements to the IList
	 */
	public long addAMillion(IList l);

	/**
	 * @return the number of milliseconds it takes to add a billion elements to the IList
	 */
	public long addABillion(IList l);

	/**
	 * @return the number of milliseconds it takes to add n elements to the IList
	 */
	public long addN(IList l, long n);
	
	/**
	 * @return the number of milliseconds it takes to count the number of chars and words in a given file
	 */
	public long textFileInfo(String fileName, IList charList, IList wordList);
	
	/**
	 * @return the number of milliseconds it takes to reverse the order of the elements in this list
	 */
	public long reverseOrder(IList l);

}
