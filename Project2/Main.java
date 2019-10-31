class Main {
    public static void main(String[] args) throws Exception {

        try {
            Set<Integer> setElements = new Set<Integer>();
            setElements.add(new Integer(36));
            List<Integer> newList = new List<>();
            newList.add(new Integer(69));
            newList.add(29);
            setElements.add(newList);
            System.out.println(" get " + setElements.get(5));
            System.out.println(" index " + setElements.indexOf(29));
            System.out.println(" contains " + setElements.contains(93));
            setElements.remove(1);
            Set<Integer> tempSet = new Set<Integer>();
            tempSet.add(new Integer(192));
            tempSet.add(69);
            System.out.println(" subset " + setElements.isSubSet(tempSet));
            Set un = setElements.union(tempSet);
            Set in = setElements.intersection(tempSet);

            for (int i = 0; i < in.size; i++) {
                System.out.println(in.get(i));
            }

            System.out.println("--------------------------------------------");
            OrderedSet<Integer> orderedSetElements = new OrderedSet<Integer>();
            orderedSetElements.add(new Integer(36));
            List<Integer> tempList = new List<>();
            tempList.add(new Integer(69));
            tempList.add(29);
            orderedSetElements.add(newList);
            for (int i = 0; i < orderedSetElements.size; i++) {
                System.out.println(orderedSetElements.get(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + " hello ");
        }
        
        List<Integer> ls = new List<Integer>();
        ls.add(new Integer(36));
        List<Integer> newList = new List<Integer>();
        newList.add(new Integer(69));
        newList.add(29);
        ls.addAll(newList);
        for (int i = 0; i < ls.size; i++) {
            System.out.println(ls.get(i));
        }
        OrderedList<Integer> ls1 = new OrderedList<Integer>();
        ls1.add(new Integer(36));
        List<Integer> newList1 = new List<Integer>();
        newList1.add(new Integer(69));
        ls1.addAll(newList1);
        System.out.println("----------------");
        for (int i = 0; i < ls1.size; i++) {
            System.out.println(ls1.get(i));
        }
    }
}