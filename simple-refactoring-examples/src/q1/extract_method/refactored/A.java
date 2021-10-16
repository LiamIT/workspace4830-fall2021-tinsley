package q1.extract_method.refactored;

import java.util.List;

import p5.extract_method_typeparameterize.refactored.Graph;

public class A {
   Node m1(List<Node> nodes, String p) {
      // TODO: Your answer
	   extractedMethod(nodes, p);
      // other implementation
      return null;
   }

   Edge m2(List<Edge> edgeList, String p) {
      // TODO: Your answer
	   extractedMethod(edgeList, p);
      // other implementation
      return null;
   }

   // TODO: Your answer
   <type extends General> void extractedMethod(List<type> listIn, String p) {
   for (type parts : listIn) {
       if (parts.contains(p))
          System.out.println(parts);
    }
 }
}


	class General 
	{
	   String name;

	   public boolean contains(String p) {
	      return name.contains(p);
	   }

	}

	class Node extends General {
	}

	class Edge extends General {
	}