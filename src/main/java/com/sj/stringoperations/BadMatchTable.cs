class BadMatchTable {
    readonly int missing;
    readonly Dictionary<int, int> table;

    public BadMatchTable(string pattern) {
        missing = pattern.Length;
        table = new Dictionary<int, int>();

        for(int i = 0; i< pattern.Length - 1; i++) {
            table[pattern[i]] = pattern.Length - i - 1;
        }
    }
    public int this[int index] {
        get {
            return table.GetValueOrDefault(index, missing);
        }
    }
}

/*

        StringSearch ss = new StringSearch();

//        List<Integer> index = ss.linearSearch(sc.nextLine(), sc.nextLine());
//        if (index != null) {
//            System.out.println("matching indices are : "+index.toString());
//        }
//        else {
//            System.out.println("Not found");
//        }
        List<Integer> list =  ss.bmhStringSearch("If I going to tell truth, then truth will have no value.","truth");
//        List<Integer> list =  ss.bmhStringSearch("atrutha", "truth");
        System.out.println(list);

*/