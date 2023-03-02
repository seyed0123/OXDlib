public class Book {
    private String name;
    private String author;
    private int yearOfPublish;
    private int ISBN;
    private int num;
    public Book(String name , String author , int yearOfPublish , int num ,int ISBN)
    {
        this.ISBN=ISBN;
        this.name=name;
        this.author=author;
        this.yearOfPublish=yearOfPublish;
        this.num=num;
    }
    public boolean decreaseBook(int number)
    {
        if(number>this.num)
            return false;
        else
            this.num-=number;
        return true;
    }
    public void increaseBook(int number)
    {
        this.num+=number;
    }
    public void updateBook(int year){
        this.yearOfPublish = year;
    }
    public int getNum()
    {
        return this.num;
    }
}
