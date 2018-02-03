package com.johnmiller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Ticker implements ISubject<TickerUpdate> {

    private List<IObserver<TickerUpdate>> observers;

    Ticker(){
        this.observers = new ArrayList<>();
    }

    public void readAndUpdate(){

        String fileName = "Ticker.dat";
        String line;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            TickerUpdate tu = new TickerUpdate();
            while((line = bufferedReader.readLine()) != null) {
                String[] splited = line.split("\\s+");
                if(splited.length > 1){
                    if(splited[0].equals("Last")){
                        if(tu.getTickerItems().size() > 0){
                            this.update(tu);
                        }
                        tu = new TickerUpdate();
                        tu.setUpdatedString(String.join(" ", Arrays.copyOfRange(splited,2, 7)));
                    }else{
                        int len = splited.length;
                        tu.addTickerItem(new TickerItem(
                                String.join(" ", Arrays.copyOfRange(splited,0,len - 8)),
                                splited[len - 8],
                                Double.parseDouble(splited[len - 7]),
                                Double.parseDouble(splited[len - 6]),
                                Double.parseDouble(splited[len - 5]),
                                Double.parseDouble(splited[len - 4]),
                                Double.parseDouble(splited[len - 3]),
                                Double.parseDouble(splited[len - 2]),
                                splited[len - 1].equals("-")? 0.0 : Double.parseDouble(splited[len - 1])
                        ));
                    }
                }

            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }

    @Override
    public void register(IObserver<TickerUpdate> observer) {
        this.observers.add(observer);
    }

    @Override
    public void remove(IObserver<TickerUpdate> observer) {
        this.remove(observer);
    }

    @Override
    public void update(TickerUpdate u) {
        this.observers.forEach(o -> o.handleUpdate(u));
    }
}
