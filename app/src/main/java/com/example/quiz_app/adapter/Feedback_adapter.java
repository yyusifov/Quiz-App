package com.example.quiz_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz_app.R;

import java.util.List;

public class Feedback_adapter extends RecyclerView.Adapter<Feedback_adapter.ViewHolder> {
    List<Integer> wrongAnswers;
    public Feedback_adapter(List<Integer> wrongAnswers){
        this.wrongAnswers = wrongAnswers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_row, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Feedback_adapter.ViewHolder holder, int position) {
        if(wrongAnswers.get(position) == 1){
            holder.feedback_text.setText("Question 1. " + "Electric vehicles produce lower emissions compared to conventional internal combustion engine vehicles. Since EVs run on electricity, they do not emit tailpipe pollutants like gasoline or diesel vehicles, which helps combat air pollution and reduce greenhouse gas contributions, contributing to a cleaner environment.");
        }
        else if(wrongAnswers.get(position) == 2){
            holder.feedback_text.setText("Question 2. " + "Advancements in battery technology have significantly improved the range and charging capabilities of electric vehicles. Modern batteries offer better energy storage, leading to increased driving range and faster charging times, making EVs more practical for daily use and reducing \"range anxiety.\"");
        }
        else if(wrongAnswers.get(position) == 3){
            holder.feedback_text.setText("Question 3. " + "Electric vehicles, by producing lower emissions, play a crucial role in reducing air pollution. By shifting from conventional vehicles to EVs, we can decrease harmful pollutants released into the atmosphere, contributing to efforts to combat climate change and improve air quality.");
        }
        else if(wrongAnswers.get(position) == 4){
            holder.feedback_text.setText("Question 4. " + " Government incentives and rebates significantly influence the adoption of electric vehicles by consumers. These incentives can include tax credits, reduced registration fees, or financial incentives, making electric vehicles more affordable and encouraging consumers to choose them over traditional gasoline-powered vehicles.");
        }
        else if(wrongAnswers.get(position) == 5){
            holder.feedback_text.setText("Question 5. " + "Advancements in battery technology have improved the range (distance an EV can travel on a single charge) and charging capabilities (speed at which the battery can be charged). These improvements make electric vehicles more convenient and practical for everyday use, enhancing their appeal to consumers.");
        }
    }

    @Override
    public int getItemCount() {
        return wrongAnswers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView feedback_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            feedback_text = itemView.findViewById(R.id.feedback_text);
        }
    }
}
