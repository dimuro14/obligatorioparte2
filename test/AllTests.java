import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import binarytree.withnode.SearchBinaryTreeImplTest;
import hash.HashImplTest;
import heap.HeapImplTest;
import linkedlist.LinkedListImplTest;
import queue.QueueImplTest;
import stack.StackImplTest;

@RunWith(Suite.class)
@SuiteClasses({QueueImplTest.class, StackImplTest.class, LinkedListImplTest.class, SearchBinaryTreeImplTest.class, HashImplTest.class, HeapImplTest.class})
public class AllTests {

}
