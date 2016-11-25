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
public class trumpPolitcalComparison extends ListFragment implements OnItemClickListener {

    /**
     * List content
     */
    private static final String[] MOVIES = new String[] {
            "\nCrime\n" +
                    "\t" +
                    "Allow states to legalize marijuana if they chose to do so\n" +
                    "\t" +
                    "Legalize drugs to take profit away from drug cartels\n" +
                    "\t" +
                    "Defend the Second Amendment of our Constitution\n" +
                    "\t" +
                    "Nominate United States Supreme Court justices that will abide by the rule of law and the Constitution of the United States that includes upholding the Second Amendment\n" +
                    "\t" +
                    "Expand and bring back programs like Project Exile and get gang members and drug dealers off the street\n" +
                    "\t" +
                    "Education\n" +
                    "\tImmediately add an additional federal investment of $20 billion towards school choice\n" +
                    "\tGive states the option to allow these funds to follow the student to the public or private school they attend\n" +
                    "\tEstablish the national goal of providing school choice to every one of the 11 million school aged children living in poverty\n" +
                    "\tWork with Congress on reforms to ensure universities are making a good faith effort to reduce the cost of college and student debt\n" +
                    "\tEnsure that the opportunity to attend a two or four-year college, or to pursue a trade or a skill set through vocational and technical education, will be easier to access, pay for, and finish\n",
            "\nEnvironment\n" +
                    "\tMake America energy independent, create millions of new jobs, and protect clean air and clean water\n",
            "\nFamilies\n" +
                    "\tRewrite the tax code to allow working parents to deduct from their income taxes child care expenses for up to four children and elderly dependents\n" +
                    "\t" +
                    "Allow parents to enroll in tax-free dependent care savings accounts for their children or elderly relatives\n" +
                    "\t" +
                    "Provide low-income households an Expanded Earned Income Tax Credit\n" +
                    "\t" +
                    "Create a new, dynamic market for family-based and community-based solutions.\n" +
                    "\t" +
                    "Incentivize employers to provide childcare at the workplace\n" +
                    "\t" +
                    "Foreign Policy\n" +
                    "Strengthen the U.S. military and deploy it appropriately in the East and South China Seas\n" +
                    "\t" +
                    "Put an end to China’s illegal export subsidies and lax labor and environmental standards\n" +
                    "\t" +
                    "Bolster the U.S. military presence in the East and South China Seas to discourage Chinese adventurism\n" +
                    "\t" +
                    "Enforce stronger protections against Chinese hackers and counterfeit goods\n" +
                    "\t" +
                    "Adopt a zero tolerance policy on intellectual property theft and forced technology transfer\n" +
                    "\t" +
                    "Close parts of the Internet to prevent ISIS from attracting recruits\n" +
                    "\t" +
                    "Increase cooperation between the United States and Russia\n" +
                    "\t" +
                    "Work with Congress to fully repeal the defense sequester and submit a new budget to rebuild our military\n" +
                    "\t" +
                    "Increase the size of the U.S. Army to 540,000 active duty soldiers\n" +
                    "\t" +
                    "Rebuild the U.S. Navy toward a goal of 350 ships\n" +
                    "\t" +
                    "Provide the U.S. Air Force with 1,200 fighter aircraft\n" +
                    "\t" +
                    "Grow the U.S. Marine Corps to 36 battalions\n" +
                    "\t" +
                    "Invest in a serious missile defense system to meet growing threats\n" +
                    "\t" +
                    "Emphasize cyber warfare\n" +
                    "\t" +
                    "Pay for this necessary rebuilding of our national defense by conducting a full audit of the Pentagon\n" +
                    "\t" +
                    "Peace through strength will be at the center of our foreign policy\n" +
                    "\t" +
                    "Advance America’s core national interests, promote regional stability, and produce an easing of tensions in the world\n" +
                    "\t" +
                    "Rebuild our military, enhance and improve intelligence and cyber capabilities\n" +
                    "\t" +
                    "End the current strategy of nation-building and regime change\n" +
                    "\t" +
                    "Ensure our security procedures and refugee policy takes into account the security of the American people\n" +
                    "\t" +
                    "Work with our Arab allies and friends in the Middle East in the fight against ISIS\n" +
                    "\t" +
                    "Pursue aggressive joint and coalition military operations to destroy ISIS\n" +
                    "\t" +
                    "Defeat the ideology of radical Islamic terrorism just as we won the Cold War\n" +
                    "\t" +
                    "Establish new screening procedures and enforce our immigration laws to keep terrorists out of the United States\n" +
                    "\t" +
                    "Suspend, on a temporary basis, immigration from some of the most dangerous and volatile regions of the world that have a history of exporting terrorism\n" +
                    "\t" +
                    "Establish a Commission on Radical Islam\n" +
                    "\t" +
                    "Declare American energy dominance a strategic economic and foreign policy goal of the United States.\n",
            "\nGovernment\n" +
                    "\t" +
                    "Eliminate waste, fraud and abuse in Federal government spending\n" +
                    "\t" +
                    "Ask all Department heads to submit a list of every wasteful and unnecessary regulation\n" +
                    "\t" +
                    "Reform the entire regulatory code\n" +
                    "\t" +
                    "End regulations that force jobs out of our communities and inner cities\n" +
                    "\t" +
                    "Issue a temporary moratorium on new agency regulations that are not compelled by Congress or public safety\n" +
                    "\t" +
                    "Immediately cancel all illegal and overreaching executive orders\n" +
                    "\t" +
                    "Eliminate our most intrusive regulations\n" +
                    "\t" +
                    "Decrease the size of our government after a thorough agency review\n",
            "\nHealthcare\n" +
                    "\tIncrease funding for PTSD, traumatic brain injury and suicide prevention services\n" +
                    "\t" +
                    "Increase funding for job training and placement services, educational support and business loans\n" +
                    "\t" +
                    "Transform the VA to meet the needs of st century service members\n" +
                    "\t" +
                    "Better support our women veterans\n" +
                    "\t" +
                    "Fire the corrupt and incompetent VA executives\n" +
                    "\t" +
                    "End waste, fraud and abuse at the VA\n" +
                    "\t" +
                    "Empower the caregivers to ensure our veterans receive quality care quickly\n" +
                    "\t" +
                    "Hire more veterans to care for veterans\n" +
                    "\t" +
                    "Embed satellite VA clinics in rural and other underserved areas\n" +
                    "\t" +
                    "Defund Planned Parenthood\n" +
                    "\t" +
                    "Ensure our veterans get the care they need wherever and whenever they need it\n" +
                    "\t" +
                    "Appoint a VA Secretary whose sole purpose will be to serve veterans\n" +
                    "\t" +
                    "Use the powers of the presidency to remove and discipline the federal employees and managers who have violated the public's trust and failed to carry out the duties on behalf of our veterans\n" +
                    "\t" +
                    "Ask that Congress pass legislation that empowers the Secretary of the VA to discipline or terminate any employee who has jeopardized the health, safety or well-being of a veteran\n" +
                    "\t" +
                    "Create a commission to investigate all the fraud, cover-ups, and wrong-doing that has taken place in the VA\n" +
                    "\t" +
                    "Protect and promote honest employees at the VA who highlight wrongdoing\n" +
                    "\t" +
                    "Create a private White House hotline, which will be active  hours a day answered by a real person\n" +
                    "\t" +
                    "Stop giving bonuses to any VA employees who are wasting money, and start rewarding employees who seek to improve the VA's service\n" +
                    "\t" +
                    "Reform the visa system to ensure veterans are at the front of the line for health services\n" +
                    "\t" +
                    "Increase the number of mental health care professionals, and allow veteran's to be able to seek mental health care outside of the VA\n" +
                    "\t" +
                    "Ensure every veteran has the choice to seek care at the VA or at a private service provider of their own choice\n" +
                    "\t" +
                    "Repeal and replace Obamacare with Health Savings Accounts (HSAs)\n" +
                    "\t" +
                    "Work with Congress to create a patient-centered health care system\n" +
                    "\t" +
                    "Work with states to establish high-risk pools to ensure access to coverage for individuals who have not maintained continuous coverage\n" +
                    "\t" +
                    "Allow people to purchase insurance across state lines\n" +
                    "\t" +
                    "Maximize flexibility for states via block grants\n",
            "\nImmigration\n" +
                    "\tBuild a wall along the Mexican border\n" +
                    "\tLaws passed in accordance with our Constitutional system of government must be enforced\n" +
                    "\tAny immigration plan must improve jobs, wages and security for all Americans\n" +
                    "\tTriple the number of ICE officers\n" +
                    "\tImplement a nationwide e-verify\n" +
                    "\tDeport all illegal immigrants\n" +
                    "\tDetain all illegal immigrants until they are deported\n" +
                    "\tCut-off federal grants to any city which acts as a \"sanctuary city\" and refuses to cooperate with federal law enforcement\n" +
                    "\tEnhanced penalties for overstaying a visa\n" +
                    "\tCooperate with local gang task forces\n" +
                    "\tEnd birthright citizenship\n" +
                    "\tIncrease prevailing wage for H-Bs\n" +
                    "\tRequire companies to hire American workers first\n" +
                    "\tEnd welfare abuse\n" +
                    "\tRequire employers to hire from the domestic pool of unemployed immigrant and native workers before issuing new green cards to foreign workers\n" +
                    "\tIncrease standards for the admission of refugees and asylum-seekers to crack down on abuses\n" +
                    "\tTemporarily halt Muslim immigration as long as the threat of ISIS persists\n",
            "\nJobs & Economy\n" +
                    "\tBring China to the bargaining table by immediately declaring it a currency manipulator\n" +
                    "\tForce China to uphold intellectual property laws\n" +
                    "\tPut an end to China’s illegal export subsidies and lax labor and environmental standards\n" +
                    "\tPlace a % tariff on Chinese exports to the United States\n" +
                    "\tWithdraw from the Trans-Pacific Partnership\n" +
                    "\tImpose a % import tax on Mexican border\n" +
                    "\tImpose a % tax on all imported goods\n" +
                    "\tMandate a % tax for outsourcing jobs\n" +
                    "\tIntroduce a deficit-neutral plan targeting substantial new infrastructure investments\n" +
                    "\tPursue an \"America’s Infrastructure First\" policy\n" +
                    "\tRefocus government spending on American infrastructure and away from the Obama-Clinton globalization agenda\n" +
                    "\tProvide maximum flexibility to the states\n" +
                    "\tCreate thousands of new jobs in construction, steel manufacturing, and other sectors\n" +
                    "\tPut American steel made by American workers into the backbone of America’s infrastructure\n" +
                    "\tLeverage new revenues and work with financing authorities, public-private partnerships, and other prudent funding opportunities\n" +
                    "\tHarness market forces to help attract new private infrastructure investments through a deficit-neutral system of infrastructure tax credits\n" +
                    "\tImplement a bold, visionary plan for a cost-effective system of roads, bridges, tunnels, airports, railroads, ports and waterways, and pipelines\n" +
                    "\tLink increases in spending to reforms that streamline permitting and approvals, improve the project delivery system, and cut wasteful spending\n" +
                    "\tEmploy incentive-based contracting to ensure projects are on time and on budget\n" +
                    "\tApprove private sector energy infrastructure projects to better connect American coal and shale energy production with markets and consumers\n" +
                    "\tWork with Congress to modernize our airports and air traffic control systems, end long wait times, and reform the FAA and TSA\n" +
                    "\tIncorporate new technologies and innovations into our national transportation system\n" +
                    "\tMake clean water a high priority\n" +
                    "\tLink increased investments with positive reforms to infrastructure programs that reduce waste and cut costs\n" +
                    "\tAppoint tough and smart trade negotiators to fight on behalf of American workers\n" +
                    "\tDirect the Secretary of Commerce to identify every violation of trade agreements a foreign country is currently using to harm our workers\n" +
                    "\tTell NAFTA partners that we intend to immediately renegotiate the terms of that agreement\n" +
                    "\tInstruct the Treasury Secretary to label China a currency manipulator\n" +
                    "\tInstruct the U.S. Trade Representative to bring trade cases against China\n" +
                    "\tUse every lawful presidential power to remedy trade disputes if China does not stop its illegal activities\n" +
                    "\tUnleash America’s $ trillion in untapped shale, oil, and natural gas reserves, plus hundreds of years in clean coal reserves\n" +
                    "\tBecome independent of any need to import energy from the OPEC cartel or any nations hostile to our interests\n" +
                    "\tOpen onshore and offshore leasing on federal lands, eliminate moratorium on coal leasing, and open shale energy deposits\n" +
                    "\tEncourage the use of natural gas and other American energy resources\n" +
                    "\tRescind all job-destroying Obama executive actions\n" +
                    "\tCreate a dynamic booming economy that will create  million new jobs over the next decade\n" +
                    "\tReform policies with a pro-growth tax plan, a new modern regulatory framework, an America-First trade policy, an unleashed American energy plan, and the \"penny plan\"\n" +
                    "\tBoost growth to . percent per year on average\n",
            "\nScience & Tech\n" +
                    "\t" +
                    "Order an immediate review of all U.S. cyber defenses and vulnerabilities\n" +
                    "\t" +
                    "Instruct the U.S. Department of Justice to create Joint Task Forces to coordinate responses to cyber threats\n" +
                    "\t" +
                    "Order the Secretary of Defense and Chairman of the Joint Chiefs of Staff to provide recommendations for enhancing U.S. Cyber Command\n" +
                    "\t" +
                    "Develop the offensive cyber capabilities we need to deter attacks by both state and non-state actors\n",
            "\nTaxes\n" +
                    "\t" +
                    "Reduce or eliminate most deductions and loopholes available to the very rich\n" +
                    "\t" +
                    "Eliminate the income tax for single individuals earning less than $25,000 or those married and jointly earn less than $50,000\n" +
                    "\t" +
                    "Create a 15% flat tax on businesses\n" +
                    "\t" +
                    "Eliminate the death tax\n" +
                    "\t" +
                    "Reduce or eliminate most deductions and loopholes available to the very rich\n" +
                    "\t" +
                    "Introduce a one-time deemed repatriation of corporate cash held overseas at a significantly discounted 10% tax rate\n" +
                    "\t" +
                    "Reduce or eliminate corporate loopholes that cater to special interests\n" +
                    "\t" +
                    "Simplify the tax code into four brackets from seven brackets - 0%, 10%, 20%, and 25%"
    };

    /**
     * The header to bind the {@link BackScrollManager} to
     */
    private CarouselContainer mCarousel;

    /**
     * Empty constructor as per the {@link Fragment} docs
     */
    public trumpPolitcalComparison() {
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
