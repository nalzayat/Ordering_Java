import java.util.*;
public class Orders{

  // Produce all possible orders of specials with replacement;
  // currentOrder is the current order of specials and maxSize is
  // the maximum length desired. allOrderings accumulates string
  // results as they are found.
  public static void orders(ArrayList<String> specials,
                            ArrayList<String> currentOrder,
                            int maxSize,
                            ArrayList<String> allOrders){
    // If currentOrder contains enough specials, add it to the list of
    // allOrders that have been found
    if(currentOrder.size() == maxSize){
      allOrders.add(currentOrder.toString());
      return;
    }

    // Haven't reached maxSize so add each possible special to the
    // end of allOrders and recurse down to continue the
    // search. Remove the special after finishing the recursive call
    // to replace it with another special.
    for(String special : specials){
      currentOrder.add(special);
      orders(specials, currentOrder, maxSize, allOrders);
      currentOrder.remove( currentOrder.size()-1 );
    }
    return;
  }

  // Produce all possible orders of specials with replacement but
  // ensure that no adjacent specials are identical (no adjacent
  // repeats).
  public static void ordersNoAdj(ArrayList<String> specials,
                                 ArrayList<String> currentOrder,
                                 int maxSize,
                                 ArrayList<String> allOrders){
    
   // If currentOrder contains enough specials, add it to the list of
    // allOrders that have been found
    if(currentOrder.size() == maxSize){
      allOrders.add(currentOrder.toString());
      return;
    }

    // Haven't reached maxSize so add each possible special to the
    // end of allOrders and recurse down to continue the
    // search. Remove the special after finishing the recursive call
    // to replace it with another special.
    for(String special : specials){
      // If the currentOrders size is not zero
         if(currentOrder.size() != 0){
           // If the special is the same as the previous one 
            if(special.equals(currentOrder.get(currentOrder.size()-1))){
               continue;
            }
         }
         // Same as before 
         currentOrder.add(special);
         ordersNoAdj(specials, currentOrder, maxSize, allOrders);
         currentOrder.remove( currentOrder.size()-1 );
      }
      return;
   }

  // Produce all possible orders of specials WITHOUT replacement: each
  // special in an order in allOrders should be unique.
  public static void ordersNoRepeats(ArrayList<String> specials,
                                     ArrayList<String> currentOrder,
                                     int maxSize,
                                     ArrayList<String> allOrders){
    int switch1 = 0;
      if(currentOrder.size() == maxSize){
         allOrders.add(currentOrder.toString());
         return;
      }
   
      // Haven't reached maxSize so add each possible special to the
      // end of allOrders and recurse down to continue the
      // search. Remove the special after finishing the recursive call
      // to replace it with another special.
      for(String special : specials){
         if(currentOrder.size()!=0){
           // For loops through current order
            for(int x = 0; x < currentOrder.size(); x++){
              // If the current special is already there flip the switch
               if(special.equals(currentOrder.get(x))){
                  switch1++;
               }
            }
         }
         if(switch1 == 0){
            currentOrder.add(special);
            ordersNoRepeats(specials, currentOrder, maxSize, allOrders);
            currentOrder.remove( currentOrder.size()-1 );
         }switch1 = 0;
      }
      return;
  }

  public static void main(String args[]){
    ArrayList<String> specials = new ArrayList<String>();
    specials.add("10 Coins Off");
    specials.add("Crushed Turtle");
    specials.add("Firey Flower Pasta");
    specials.add("Mushroom Veal");
    specials.add("Stewed Goomba");

    ArrayList<String> currentOrder = new ArrayList<String>();
    ArrayList<String> allOrders = new ArrayList<String>();
    int maxSize = 4;
    orders(specials, currentOrder, maxSize, allOrders);

    System.out.printf("%d orders\n",allOrders.size());
    for(String order : allOrders){
      System.out.println(order);
    }


    System.out.println();

    // Now without adjacent repeats
    allOrders.clear();
    currentOrder.clear();
    ordersNoAdj(specials, currentOrder, maxSize, allOrders);

    System.out.printf("%d orders\n",allOrders.size());
    for(String order : allOrders){
      System.out.println(order);
    }

    System.out.println();

    // Now without any repeats
    allOrders.clear();
    currentOrder.clear();
    ordersNoRepeats(specials, currentOrder, maxSize, allOrders);

    System.out.printf("%d orders\n",allOrders.size());
    for(String order : allOrders){
      System.out.println(order);
    }
    
  }



}
