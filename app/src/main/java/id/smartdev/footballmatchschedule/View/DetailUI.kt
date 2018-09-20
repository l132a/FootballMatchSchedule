package id.smartdev.footballmatchschedule.View

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import id.smartdev.footballmatchschedule.R
import android.widget.LinearLayout
import org.jetbrains.anko.*

class DetailUI: AnkoComponent<Context> {
    override fun createView(ui: AnkoContext<Context>): View {
        return with(ui){
            relativeLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundColor = Color.WHITE

                scrollView {
                    lparams(width = matchParent, height = wrapContent)
                    //---Contaner---//
                    linearLayout {
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.VERTICAL
                        topPadding = dip(8)
                        leftPadding = dip(8)
                        rightPadding = dip(8)

                        textView {
                            id = R.id.tv_date_event
                            gravity = Gravity.CENTER
                            typeface = Typeface.DEFAULT_BOLD
                            textColor = Color.BLUE
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                            bottomMargin = dip(2)
                        }
                        textView {
                            id = R.id.tv_time_event
                            gravity = Gravity.CENTER
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                        }
                        //---Badge---//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 3f

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                gravity = Gravity.CENTER_HORIZONTAL

                                imageView {
                                    id = R.id.iv_home_badge
                                }.lparams {
                                    height = dip(100)
                                    width = dip(100)
                                }
                            }
                            //---Score--//
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                linearLayout {
                                    lparams(width = matchParent, height = matchParent)
                                    weightSum = 3f
                                    orientation = LinearLayout.HORIZONTAL

                                    linearLayout {
                                        lparams(width = dip(0), height = matchParent, weight = 1f)
                                        orientation = LinearLayout.VERTICAL
                                        gravity = Gravity.CENTER

                                        textView {
                                            id = R.id.tv_home_score
                                            gravity = Gravity.END
                                            typeface = Typeface.DEFAULT_BOLD
                                            textSize = 40f
                                        }.lparams {
                                            width = matchParent
                                            height = wrapContent
                                        }
                                    }
                                    linearLayout {
                                        lparams(width = dip(0), height = matchParent, weight = 1f)
                                        orientation = LinearLayout.VERTICAL
                                        gravity = Gravity.CENTER

                                        textView {
                                            id = R.id.tv_vs_match
                                            gravity = Gravity.CENTER
                                            typeface = Typeface.DEFAULT_BOLD
                                        }.lparams {
                                            width = matchParent
                                            height = wrapContent
                                        }
                                    }
                                    linearLayout {
                                        lparams(width = dip(0), height = matchParent, weight = 1f)
                                        orientation = LinearLayout.VERTICAL
                                        gravity = Gravity.CENTER

                                        textView {
                                            id = R.id.tv_away_score
                                            gravity = Gravity.START
                                            typeface = Typeface.DEFAULT_BOLD
                                            textSize = 40f
                                        }.lparams {
                                            width = matchParent
                                            height = wrapContent
                                        }
                                    }
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                gravity = Gravity.CENTER_HORIZONTAL

                                imageView {
                                    id = R.id.iv_away_badge
                                }.lparams {
                                    height = dip(100)
                                    width = dip(100)
                                }
                            }
                        }
                        //---Team---//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            orientation = LinearLayout.HORIZONTAL
                            weightSum = 3f

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                gravity = Gravity.CENTER_HORIZONTAL

                                textView {
                                    id = R.id.tv_home_team
                                    gravity = Gravity.CENTER
                                    typeface = Typeface.DEFAULT_BOLD
                                    singleLine = true
                                    ellipsize = TextUtils.TruncateAt.END
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                                textView {
                                    id = R.id.tv_home_formation
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    typeface = Typeface.DEFAULT_BOLD
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                gravity = Gravity.CENTER_HORIZONTAL

                                textView {
                                    id = R.id.tv_away_team
                                    gravity = Gravity.CENTER
                                    typeface = Typeface.DEFAULT_BOLD
                                    singleLine = true
                                    ellipsize = TextUtils.TruncateAt.END
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = wrapContent
                                    height = wrapContent
                                }
                                textView {
                                    id = R.id.tv_away_formation
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    typeface = Typeface.DEFAULT_BOLD
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        view {
                            backgroundColor = Color.GRAY
                        }.lparams(width = matchParent, height = dip(2))
                        //---Goals---//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_goals
                                    gravity = Gravity.LEFT
                                }.lparams {
                                    width = matchParent
                                    height = matchParent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_goals
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_goals
                                    gravity = Gravity.RIGHT
                                }.lparams {
                                    width = matchParent
                                    height = matchParent
                                }
                            }
                        }
                        // ----Shot----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_shots
                                    gravity = Gravity.LEFT
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_shots
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_shots
                                    gravity = Gravity.RIGHT
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        view {
                            backgroundColor = Color.GRAY
                        }.lparams(width = matchParent, height = dip(2))

                        textView {
                            id = R.id.tv_lineups
                            gravity = Gravity.CENTER_HORIZONTAL
                        }.lparams {
                            width = matchParent
                            height = wrapContent
                        }
                        // ----Goals Keeper----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_keeper
                                    gravity = Gravity.START
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_keeper
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_keeper
                                    gravity = Gravity.END
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        // ----Defense----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_defense
                                    gravity = Gravity.START
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_defense
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_defense
                                    gravity = Gravity.END
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        // ----Yellow Card----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_yellow_card
                                    gravity = Gravity.START
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_yellow_card
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_yellow_card
                                    gravity = Gravity.END
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        // ----Red Card----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_red_card
                                    gravity = Gravity.START
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_red_card
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_red_card
                                    gravity = Gravity.END
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        // ----Midfield----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_midfield
                                    gravity = Gravity.START
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_midfield
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_midfield
                                    gravity = Gravity.END
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        // ----Forwoard----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_forwoard
                                    gravity = Gravity.START
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_forwoard
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_forwoard
                                    gravity = Gravity.END
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                        // ----Substitutes----//
                        linearLayout {
                            lparams(width = matchParent, height = matchParent)
                            weightSum = 3f
                            padding = dip(8)

                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_home_substitutes
                                    gravity = Gravity.START
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_substitutes
                                    gravity = Gravity.CENTER_HORIZONTAL
                                    textColor = Color.BLUE
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                            linearLayout {
                                lparams(width = matchParent, height = matchParent, weight = 1f)
                                orientation = LinearLayout.VERTICAL
                                textView {
                                    id = R.id.tv_away_substitutes
                                    gravity = Gravity.END
                                }.lparams {
                                    width = matchParent
                                    height = wrapContent
                                }
                            }
                        }
                    }

                }
                progressBar {
                    id = R.id.pb_loading
                }.lparams {
                    centerHorizontally()
                }
            }
        }
    }
}