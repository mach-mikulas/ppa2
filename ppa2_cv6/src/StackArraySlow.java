public class StackArraySlow extends StackArray{

    @Override
    public void expandArray(){

        String[] newData = new String[data.length + 10];

        for(int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }

        data = newData;
    }
}
