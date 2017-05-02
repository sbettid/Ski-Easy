package skieasy.decy.it.ski_easy;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Davide on 02/05/2017.
 */

public class myAdapter  extends ArrayAdapter <String[]>  {

    private final String[][] ratings;
    private final Context context;

    public myAdapter(@NonNull Context context, @NonNull String[][] objects) {
        super(context, R.layout.review_line, objects);
        this.ratings = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.review_line, parent, false);

        TextView user = (TextView) rowView.findViewById(R.id.textView10);
        user.setText(ratings[position][0]);

        RatingBar bar = (RatingBar) rowView.findViewById(R.id.ratingBar);
        float rating = Float.parseFloat(ratings[position][2]);
        bar.setStepSize(1);
        bar.setRating(rating);
        bar.setClickable(false);
        bar.setIsIndicator(true);
        TextView review = (TextView) rowView.findViewById(R.id.textView9);
        review.setText(ratings[position][1]);

        return rowView;
    }
    }