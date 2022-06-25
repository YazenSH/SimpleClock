import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
//Three line for Formatting the Date and Time
SimpleDateFormat timeFormat;
SimpleDateFormat dayFormat;
SimpleDateFormat dateFormat;

// 3 line to make it as label to add it to the frame
JLabel timeLabel;
JLabel dayLabel;
JLabel dateLabel;

//String to hold data
String day;
String time;
String date;

    MyFrame() throws IOException, FontFormatException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false); //not resizeable


        //formatting due to documentation
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("E");
        dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
        //time label
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50  ));
        timeLabel.setForeground(Color.GRAY);
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);
        //day label
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.PLAIN,40));
        //date label
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.PLAIN,30));

        this.add(timeLabel); //to add label in the frame
        this.add(dayLabel);
        this.add(dateLabel);
        //
        this.setVisible(true); // to pop out the window
        setTime(); //Method to refresh the frame each second
    }
//each second the loop will have another cycle to change the seconds mins. etc

    public void setTime(){
        while(true){
            //here we get the time from Calendar and formatting it using timeFormat object then we put it in a string which I set it in the Label
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);


            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

           try{ Thread.sleep(1000);
        }
        catch (InterruptedException e )
        {e.printStackTrace();}
        }





    }
}
