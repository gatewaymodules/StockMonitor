package za.co.eugenevdm.stockmonitor;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A fragment representing a single Stock detail screen.
 * This fragment is either contained in a {@link StockListActivity}
 * in two-pane mode (on tablets) or a {@link StockDetailActivity}
 * on handsets.
 */
public class StockDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    private static final String TAG = "sm_StockDetailFragment";

    /**
     * The dummy name this fragment is presenting.
     */
    private Stock.StockItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StockDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy name specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load name from a name provider.
            mItem = Stock.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stock_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.stock_name)).setText(mItem.name);
            ((TextView) rootView.findViewById(R.id.stock_exchange_ticker)).setText(mItem.exchange_ticker);
            ((TextView) rootView.findViewById(R.id.stock_price)).setText(mItem.price);
            ((TextView) rootView.findViewById(R.id.stock_pe)).setText(mItem.pe);
            ((TextView) rootView.findViewById(R.id.stock_market_cap)).setText(mItem.market_cap);
        }
        return rootView;
    }

}
