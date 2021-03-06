/*
 * Copyright (C) 2013 Andrew Neal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package shaileshrawat.mvt;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.Arrays;

/**
 * @author Andrew Neal (andrewdneal@gmail.com)
 */
public class trumpPersonalComparison extends ListFragment implements OnItemClickListener {

    /**
     * List content
     */
    private static final String[] MOVIES = new String[] {
                    "Born : 06-14-1946",
                    "Spouse(s) : Melania Trump (m. 2005), Marla Maples (m. 1993–1999), Ivana Trump (m. 1977–1992)",
                    "Children : Ivanka Trump, Barron Trump, Tiffany Trump, Eric Trump, Donald Trump Jr.",
                    "Parents : Fred Trump and Mary Anne MacLeod",
                    "Awards : NME Award for Villain of the Year",
                    "Party: :  Republican Party",
                    "Religion : Presbyterian",
                    "Net Worth : $3.7 billion",
                    "Residence : Trump Tower, New York City",
                    "Alma mater : University of Pennsylvania (BS)"
    };

    /**
     * The header to bind the {@link BackScrollManager} to
     */
    private CarouselContainer mCarousel;

    /**
     * Empty constructor as per the {@link Fragment} docs
     */
    public trumpPersonalComparison() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCarousel = (CarouselContainer) activity.findViewById(R.id.carousel_header);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Simple ArrayAdapter
        Arrays.sort(MOVIES);
        final CarouselListAdapter adapter = new CarouselListAdapter(getActivity());
        for (final String movie : MOVIES) {
            adapter.add(movie);
        }

        // Bind the data
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ListView listView = getListView();
        // Attach the BackScrollManager
        listView.setOnScrollListener(new BackScrollManager(mCarousel, null,
                CarouselContainer.TAB_INDEX_FIRST));
        // Register the onItemClickListener
        listView.setOnItemClickListener(this);
        // We disable the scroll bar because it would otherwise be incorrect
        // because of the hidden
        // header
        listView.setVerticalScrollBarEnabled(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // This is the header
        if (position == 0) {
            return;
        }

        // Remember to substract one from the touched position
        final String movie = (String) parent.getItemAtPosition(position - 1);
        Toast.makeText(getActivity(), movie, Toast.LENGTH_SHORT).show();
    }

    private static final class CarouselListAdapter extends ArrayAdapter<String> {

        /**
         * The header view
         */
        private static final int ITEM_VIEW_TYPE_HEADER = 0;

        /**
         * * The data in the list.
         */
        private static final int ITEM_VIEW_TYPE_DATA = 1;

        /**
         * Number of views (TextView, CarouselHeader)
         */
        private static final int VIEW_TYPE_COUNT = 2;

        /**
         * Fake header
         */
        private final View mHeader;

        /**
         * Constructor of <code>CarouselListAdapter</code>
         *
         * @param context The {@link Context} to use
         */
        public CarouselListAdapter(Context context) {
            super(context, 0);
            // Inflate the fake header
            mHeader = LayoutInflater.from(context).inflate(R.layout.faux_carousel, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Return a faux header at position 0
            if (position == 0) {
                return mHeader;
            }

            // Recycle ViewHolder's items
            ViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(
                        android.R.layout.simple_list_item_1, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            // Retieve the data, but make sure to call one less than the current
            // position to avoid counting the faux header.
            final String movies = getItem(position - 1);
            holder.mLineOne.get().setText(movies);
            holder.mLineOne.get().setTextSize(15);
            holder.mLineOne.get().setTypeface(null, Typeface.BOLD_ITALIC);
            return convertView;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasStableIds() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getCount() {
            return MOVIES.length + 1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public long getItemId(int position) {
            if (position == 0) {
                return -1;
            }
            return position - 1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getViewTypeCount() {
            return VIEW_TYPE_COUNT;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return ITEM_VIEW_TYPE_HEADER;
            }
            return ITEM_VIEW_TYPE_DATA;
        }
    }

    private static final class ViewHolder {

        public WeakReference<TextView> mLineOne;

        /* Constructor of <code>ViewHolder</code> */
        public ViewHolder(View view) {
            // Initialize mLineOne
            mLineOne = new WeakReference<TextView>((TextView) view.findViewById(android.R.id.text1));
        }

    }

}
