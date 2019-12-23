/*C++ program to read time in HH:MM:SS format and convert into total seconds.*/
 
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <iomanip>

#include <libintl.h>
#include <locale.h>

#define _(STRING) gettext(STRING)

using namespace std;
 
class Time
{
    private:
        int seconds;
        int hh,mm,ss;
    public:
        void getTime(void);
        void convertIntoSeconds(void);
        void displayTime(void);
};
 
void Time::getTime(void)
{
    cout << _("Enter time:") << endl;
    cout << _("Hours?   ");          cin >> hh;
    cout << _("Minutes? ");          cin >> mm;
    cout << _("Seconds? ");          cin >> ss;
}
 
void Time::convertIntoSeconds(void)
{
    seconds = hh*3600 + mm*60 + ss;
}
 
void Time::displayTime(void)
{
    cout << _("The time is = ") << setw(2) << setfill('0') << hh << ":"
                             << setw(2) << setfill('0') << mm << ":"
                             << setw(2) << setfill('0') << ss << endl;
    cout << _("Time in total seconds: ") << seconds <<endl;
}
 
int main()
{
    
    setlocale (LC_MESSAGES, "");
    bindtextdomain ("time", "po/");
    bind_textdomain_codeset ("time", "UTF-8");
    textdomain ("time");

    Time T; 
    printf(_("Welcome to the time calculator")); //test de funcionamineto con printf
    //cout << endl << "---------------------------" <<endl;
    printf(_("\n---------------------------\n"));
    T.getTime();
    T.convertIntoSeconds();
    T.displayTime();
     
    return 0;
}