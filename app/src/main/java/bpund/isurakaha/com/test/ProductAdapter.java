package bpund.isurakaha.com.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by isuraksha3 on 4/5/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> productsList;
    Context mContext;

    public ProductAdapter(Context mContext,ArrayList<Product> productsList) {
        this.productsList = productsList;
        this.mContext = mContext;
    }

    //This method returns menu_main new instance of our ViewHolder.
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.layout_products,null);

        //return to product view holder class
        return new ProductViewHolder(view);
    }

    //This method binds the data to the view holder.
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        Product product=productsList.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.imageView.setImageDrawable(mContext.getResources().getDrawable(product.getImage()));

    }

    //This returns the size of the List.
    @Override
    public int getItemCount() {
        return productsList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {

        // declare fields
        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;
        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewTitle= (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc= (TextView) itemView.findViewById(R.id.textViewShortDesc);
            textViewRating= (TextView) itemView.findViewById(R.id.textViewRating);
            textViewPrice= (TextView) itemView.findViewById(R.id.textViewPrice);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
