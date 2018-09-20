package id.smartdev.footballmatchschedule.View

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import id.smartdev.footballmatchschedule.R
import kotlinx.android.synthetic.main.notification_template_lines_media.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class MatchUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            cardView {
                lparams(width = matchParent, height = wrapContent){
                    margin = dip(4)
                    radius = 4f
                    background.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)

                    linearLayout {
                        lparams(width = matchParent, height = matchParent)
                        padding = dip(4)
                        orientation = LinearLayout.VERTICAL

                        textView {
                            id = R.id.tv_date_event
                            gravity = Gravity.CENTER
                            typeface = Typeface.DEFAULT_BOLD
                            textColor = Color.BLUE
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                            bottomMargin = dip(8)
                        }

                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 3f

                            linearLayout {
                                lparams(width = dip(0), height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                gravity = Gravity.CENTER

                                imageView {
                                    id = R.id.iv_home_badge
                                }.lparams {
                                    height = dip(50)
                                    width = dip(50)
                                }

                                textView {
                                    id = R.id.tv_home_team
                                    typeface = Typeface.DEFAULT_BOLD
                                    singleLine = true
                                    ellipsize = TextUtils.TruncateAt.END
                                }.lparams {
                                }
                            }
                            linearLayout {
                                lparams(width = dip(0), height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL

                                linearLayout {
                                    lparams(width = matchParent, height = matchParent)
                                    orientation = LinearLayout.HORIZONTAL
                                    weightSum = 3f

                                    linearLayout {
                                        lparams(width = matchParent, height = matchParent, weight = 1f)
                                        orientation = LinearLayout.VERTICAL
                                        gravity = Gravity.CENTER

                                        textView {
                                            id = R.id.tv_home_score
                                            typeface = Typeface.DEFAULT_BOLD
                                            textSize = 20f
                                        }.lparams {
                                            gravity = Gravity.END
                                        }

                                    }
                                    linearLayout {
                                        lparams(width = matchParent, height = matchParent, weight = 1f)
                                        orientation = LinearLayout.VERTICAL
                                        gravity = Gravity.CENTER

                                        textView {
                                            text = "VS"
                                        }.lparams {
                                            gravity = Gravity.CENTER_HORIZONTAL
                                        }
                                    }
                                    linearLayout {
                                        lparams(width = matchParent, height = matchParent, weight = 1f)
                                        orientation = LinearLayout.VERTICAL
                                        gravity = Gravity.CENTER

                                        textView {
                                            id = R.id.tv_away_score
                                            typeface = Typeface.DEFAULT_BOLD
                                            textSize = 20f
                                        }.lparams {
                                            gravity = Gravity.START
                                        }
                                    }
                                }

                            }
                            linearLayout {
                                lparams(width = dip(0), height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                gravity = Gravity.CENTER

                                imageView {
                                    id = R.id.iv_away_badge
                                }.lparams {
                                    height = dip(50)
                                    width = dip(50)
                                }

                                textView {
                                    id = R.id.tv_away_team
                                    typeface = Typeface.DEFAULT_BOLD
                                    singleLine = true
                                    ellipsize = TextUtils.TruncateAt.END
                                }.lparams {
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}