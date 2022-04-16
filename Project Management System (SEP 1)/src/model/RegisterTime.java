package model;

public class RegisterTime
{
  private Time time;
  public RegisterTime(Time time)
  {
    this.time = time;
  }
  public RegisterTime(int hours, int minutes)
  {
    validateTime(hours,minutes);
    this.time = new Time(hours, minutes);
  }
  public RegisterTime()
  {
    this.time = new Time(0);
  }
  public int getSeconds(){return time.getSecond();}
  public int getMinutes(){return time.getMinute();}
  public int getHours(){return time.getHour();}
  public Time getTime()
  {
    return time;
  }
  public void setMinutes(int minutes)
  {
    this.time.setMinute(minutes);
  }
  public void setHours(int hours)
  {
    this.time.setHour(hours);
  }
  public int getTimeInSeconds(){return getHours()*3600 + getMinutes()*60 + getSeconds();}
  public boolean equals(Object obj){
    if(!(obj instanceof RegisterTime))return false;
    RegisterTime another = (RegisterTime) obj;
    return this.getTimeInSeconds()==another.getTimeInSeconds();
  }
  public void validateTime(int timeInSeconds)
  {
    int hours;
    int minutes;
    int seconds;
    hours = timeInSeconds/3600; //13 chasa//
    minutes = timeInSeconds%3600/60; //53 min//
    //seconds = (timeInSeconds-hours)%3600%60; //20 sec//
    setHours(hours);
    setMinutes(minutes);
  }
  public void validateTime(int hours, int minutes)
  {
    if(minutes>=60)
    {
      setMinutes(minutes%=60);
      setHours(minutes/=60);
    }
  }
  public String toString()
  {
    String returnString = "";
    returnString = "hours: "  + getHours() + " minutes: " + getMinutes();
    return returnString;
  }
}
