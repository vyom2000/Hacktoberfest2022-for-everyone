import java.io.*;
import java.util.*;
public class apriori
{
    public static void main(String[] args)throws Exception
    {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        System.out.println("Enter no. of total itemset :");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter Minimum support : ");
        int ms = Integer.parseInt(br.readLine());
        System.out.println("Enter Minimum Confidence in percenatge : ");
        float con = Float.parseFloat(br.readLine());
        String[] item = new String[n];
        String[] item1 = new String[20];
        String[] validitem1 = new String[20];
        String[] item2 = new String[40];
        String[] validitem2 = new String[40];
        String[] item3 = new String[40];
        String[] validitem3 = new String[40];
        String[] item4 = new String[40];
        String[] validitem4 = new String[40];
        HashMap<String, Integer> itemset = new HashMap<String, Integer>();
        HashMap<String, Integer> itemset2 = new HashMap<String, Integer>();
        HashMap<String, Integer> itemset3 = new HashMap<String, Integer>();
        HashMap<String, Integer> itemset4 = new HashMap<String, Integer>();
        System.out.println("Enter items : ");
        for(int i=0;i<n;i++)
        {
            item[i] = br.readLine();
            item[i] = item[i].toLowerCase();
            int ns = item[i].length();
            int idx;
            String temp = "";
            for (int j = 0; j < ns; j++)
            {
                char c = item[i].charAt(j);
                idx = item[i].indexOf(c, j + 1);
                if (idx == -1)
                {
                    temp = temp + Character.toString(c);
                }
            }
            item[i]=temp;
        }
        for(int i=0;i<n;i++)
        {
            int ns = item[i].length();
            for(int j=0;j<ns;j++)
            {
                if(itemset.get(Character.toString(item[i].charAt(j))) == null)
                {
                    itemset.put(Character.toString(item[i].charAt(j)), 1);
                }
                else
                {
                    itemset.put(Character.toString(item[i].charAt(j)),itemset.get(Character.toString(item[i].charAt(j)))+1);
                }
            }
        }
        System.out.println("Itemset 1 : ");
        System.out.println(itemset);
        int k=0;
        for (String i : itemset.keySet())
        {
            if(itemset.get(i)<ms)
            {
                item1[k]=i;
                k++;
            }
        }
        for(int i=0;i<item1.length;i++)
        {
            itemset.remove(item1[i]);
        }
        k=0;
        for (String i : itemset.keySet())
        {
            validitem1[k] = i;
            k++;
        }
        int validitem1length = k+1;
        k=0;
        int inc=0;
        System.out.println("Itemset 1 after applying minimum support: ");
        System.out.println(itemset);
        for(int i=0;i<validitem1length-1;i++)
        {
            for(int j=i+1;j<validitem1length-1;j++)
            {
                item2[k] = validitem1[i] + validitem1[j];
                itemset2.put(item2[k], 0);
                for(int x=0;x<n;x++)
                {
                    for(int y=0;y<item[x].length();y++)
                    {
                        if(item2[k].charAt(0) == item[x].charAt(y) || item2[k].charAt(1) == item[x].charAt(y))
                        {
                            inc++;
                        }
                    }
                    if(inc==2)
                    {
                        itemset2.put(item2[k], itemset2.get(item2[k])+1);
                    }
                    inc=0;
                }
                k++;
            }
        }
        int validitem2length = k+1;
        System.out.println("Itemset 2: ");
        System.out.println(itemset2);
        k=0;
        for (String i : itemset2.keySet())
        {
            if(itemset2.get(i)<ms)
            {
                validitem2[k]=i;
                k++;
            }
        }
        for(int i=0;i<validitem2length;i++)
        {
            itemset2.remove(validitem2[i]);
        }
        k=0;
        for (String i : itemset2.keySet())
        {
            validitem2[k] = i;
            k++;
        }
        validitem2length = k+1;
        System.out.println("Itemset 2 after applying minimum support: ");
        System.out.println(itemset2);
        //Itemset3
        k=0;
        inc=0;
        for(int i=0;i<validitem2length-1;i++)
        {
            for(int j=i+1;j<validitem2length;j++)
            {
                item3[k] = validitem2[i] + validitem2[j];
                int ns = item3[k].length();
                int idx;
                String temp = "";
                for (int m = 0; m < ns; m++)
                {
                    char c = item3[k].charAt(m);
                    idx = item3[k].indexOf(c, m + 1);
                    if (idx == -1)
                    {
                        temp = temp + Character.toString(c);
                    }
                }
                item3[k]=temp;
                if(item3[k].length() != 3)
                {
                    continue;
                }
                itemset3.put(item3[k], 0);
                for(int x=0;x<n;x++)
                {
                    for(int y=0;y<item[x].length();y++)
                    {
                        if(item3[k].charAt(0) == item[x].charAt(y) || item3[k].charAt(1) == item[x].charAt(y) || item3[k].charAt(2) == item[x].charAt(y))
                        {
                            inc++;
                        }
                    }
                    if(inc==3)
                    {
                        itemset3.put(item3[k], itemset3.get(item3[k])+1);
                    }
                    inc=0;
                }
                k++;
            }
        }
        int validitem3length = k+1;
        System.out.println("Itemset 3: ");
        System.out.println(itemset3);
        k=0;
        for (String i : itemset3.keySet())
        {
            if(itemset3.get(i)<ms)
            {
                validitem3[k]=i;
                k++;
            }
        }
        for(int i=0;i<validitem3length;i++)
        {
            itemset3.remove(validitem3[i]);
        }
        k=0;
        for (String i : itemset3.keySet())
        {
            validitem3[k] = i;
            k++;
        }
        validitem3length = k+1;
        System.out.println("Itemset 3 after applying minimum support: ");
        System.out.println(itemset3);
        //Itemset 4
        k=0;
        inc=0;
        for(int i=0;i<validitem3length-1;i++)
        {
            for(int j=i+1;j<validitem3length;j++)
            {
                item4[k] = validitem3[i] + validitem3[j];
                int ns = item4[k].length();
                int idx;
                String temp = "";
                for (int m = 0; m < ns; m++)
                {
                    char c = item4[k].charAt(m);
                    idx = item4[k].indexOf(c, m + 1);
                    if (idx == -1)
                    {
                        temp = temp + Character.toString(c);
                    }
                }
                item4[k]=temp;
                if(item4[k].length() != 4)
                {
                    continue;
                }
                itemset4.put(item4[k], 0);
                for(int x=0;x<n;x++)
                {
                    for(int y=0;y<item[x].length();y++)
                    {
                        if(item4[k].charAt(0) == item[x].charAt(y) || item4[k].charAt(1) == item[x].charAt(y) || item4[k].charAt(2) == item[x].charAt(y) || item4[k].charAt(3) == item[x].charAt(y))
                        {
                            inc++;
                        }
                    }
                    if(inc==4)
                    {
                        itemset4.put(item4[k], itemset4.get(item4[k])+1);
                    }
                    inc=0;
                }
                k++;
            }
        }
        int validitem4length = k+1;
        System.out.println("Itemset 4: ");
        System.out.println(itemset4);
        k=0;
        for (String i : itemset4.keySet())
        {
            if(itemset4.get(i)<ms)
            {
                validitem4[k]=i;
                k++;
            }
        }
        for(int i=0;i<validitem4length;i++)
        {
            itemset4.remove(validitem4[i]);
        }
        k=0;
        for (String i : itemset4.keySet())
        {
            validitem4[k] = i;
            k++;
        }
        validitem4length = k+1;
        System.out.println("Itemset 4 after applying minimum support: ");
        System.out.println(itemset4);
        //Association rules
        System.out.println("Association rules");
        for(int i=0;i<validitem2length-1;i++)
        {
            float f1 = (float)itemset.get(Character.toString(validitem2[i].charAt(0)));
            float f2 = (float)itemset.get(Character.toString(validitem2[i].charAt(1)));
            if((f1/f2)*100 >= con)
            {
                System.out.println(validitem2[i].charAt(0)+"->"+validitem2[i].charAt(1));
            }
            f1 = (float)itemset.get(Character.toString(validitem2[i].charAt(1)));
            f2 = (float)itemset.get(Character.toString(validitem2[i].charAt(0)));
            if((f1/f2)*100 >= con)
            {
                System.out.println(validitem2[1].charAt(0)+"->"+validitem2[i].charAt(0));
            }
        }
        for(int i=0;i<validitem3length-1;i++)
        {
            float f1=1,f2=1;

            f1 = (float)itemset3.get(validitem3[i]);

            f2 = (float)itemset.get(Character.toString(validitem3[i].charAt(0)));
            if((f1/f2)*100 >= con)
            {
                System.out.println(validitem3[i].charAt(0)+"->"+validitem3[i].substring(1, 3));
            }
            if(itemset2.get(validitem3[i].substring(0, 2))==null)
            {
                f2 = (float)itemset2.get(Character.toString(validitem3[i].charAt(1))+Character.toString(validitem3[i].charAt(0)));
            }
            else
            {
                f2 = (float)(itemset2.get(validitem3[i].substring(0, 2)));
            }
            if((f1/f2)*100 >= con)
            {
                System.out.println(validitem3[i].substring(0, 2)+"->"+validitem3[i].charAt(2));
            }
            if(itemset2.get(validitem3[i].substring(1,3))==null)
            {
                f2 = (float)itemset2.get(Character.toString(validitem3[i].charAt(2))+Character.toString(validitem3[i].charAt(1)));
            }
            else
            {
                f2 = (float)itemset2.get(validitem3[i].substring(1,3));
            }
            if((f1/f2)*100 >= con)
            {
                System.out.println(validitem3[i].substring(1, 3)+"->"+validitem3[i].charAt(0));
            }
            f2 = (float)itemset.get(Character.toString(validitem3[i].charAt(2)));
            if((f1/f2)*100 >= con)
            {
                System.out.println(validitem3[i].charAt(2)+"->"+validitem3[i].substring(0, 2));
            }



            f2 = (float)itemset.get(Character.toString(validitem3[i].charAt(1)));
            if((f1/f2)*100 >= con)
            {
                System.out.println(validitem3[i].charAt(1)+"->"+Character.toString(validitem3[i].charAt(0))+Character.toString(validitem3[i].charAt(2)));
            }
            if(itemset2.get(Character.toString(validitem3[i].charAt(0))+Character.toString(validitem3[i].charAt(2)))==null)
            {
                f2 = (float)itemset2.get(Character.toString(validitem3[i].charAt(2))+Character.toString(validitem3[i].charAt(0)));
            }
            else
            {
                f2 = (float)itemset2.get(Character.toString(validitem3[i].charAt(0))+Character.toString(validitem3[i].charAt(2)));
            }
            if((f1/f2)*100 >= con)
            {
                System.out.println(Character.toString(validitem3[i].charAt(0))+Character.toString(validitem3[i].charAt(2))+"->"+validitem3[i].charAt(1));
            }
        }
    }
}
