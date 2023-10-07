package tn.esprit.gestion.Entite;

public class Zoo {

   private String name,city;
   private int nbrCages;
  private  int nbrAnimal=0;
   private Animal [] animals;

    private static int nbTotalAn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zoo(int nbrCages, String name, String city)
    {

        this.nbrCages=nbrCages;
        this.name=name;
        this.city=city;

        animals=new Animal[nbrCages];

    }
    public Zoo()
    {
        animals=new Animal[25];
    }

    public boolean addAnimal(Animal a)
    {
        if(searchAnimal(a)!=-1)
            return false;


        if(!isFull()) return false;
        animals[nbrAnimal]=a;
        nbrAnimal++;
        nbTotalAn++;
            System.out.println(nbrAnimal);

        return true;
    }


    public static int nbTotal()
    {

        return nbTotalAn;
    }
    public void display()
    {

        System.out.println("city :"+city+" name :"+name);
        for (int i=0;i<animals.length;i++) {
            if (animals[i]!=null)
            System.out.println(animals[i].getName());
        }
    }

    public  String toString()
    {
        String str="Les animaux :\n";
        //for (int i=0;i<nbrAnimal;i++)
          //str+=animals[i]+"\n";
   for (Animal a:animals) {
       if(a!=null)
       str += a + "\n";
   }
        return "city :"+city+" name :"+name+"\n"+str;
    }

    public int searchAnimal(Animal a)
    {

        for(int i=0;i<nbrAnimal;i++)
        {

            if(animals[i].getName()==a.getName())
                return i;
        }
        return -1;
    }
    public boolean removeAnimal(Animal a)
    {

        int indexAnimal=searchAnimal(a);
        if (indexAnimal==-1)
            return false;
        for (int i=indexAnimal;i<nbrAnimal;i++)
            animals[i]=animals[i+1];
        animals[nbrAnimal]=null;
        this.nbrAnimal--;
        return true;
    }
    public Zoo comparerZoo(Zoo z1)
    {
      if(this.nbrAnimal>z1.nbrAnimal)
          return this;
      else if(this.nbrAnimal<z1.nbrAnimal)
      return z1;
      return null;

    }
    public static Zoo comparerZoo(Zoo x,Zoo z2)
    {
        if(z2.nbrAnimal>x.nbrAnimal)
            return z2;
        else if(z2.nbrAnimal<x.nbrAnimal)
            return x;
        return null;
    }


    public boolean isFull()
    {
        if(nbrAnimal==animals.length)
            return true;
        return false;
    }
}
